package com.xlh.distribute.transaction.rocketmq.msg.demo.service;

import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.dao.PaymentMsgMapper;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.model.PaymentMsg;
import com.xlh.distribute.transaction.rocketmq.msg.demo.db1.model.PaymentMsgExample;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2020年12月26日 20:33 胡晓磊 Exp $
 */
@Service
public class OrderScheduler {
    @Resource
    private PaymentMsgMapper paymentMsgMapper;

    /**
     * 订单回调接口
     *
     * @return
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void orderNotify() throws IOException {
        PaymentMsgExample paymentMsgExample = new PaymentMsgExample();
        paymentMsgExample.createCriteria().andStatusEqualTo(0);
        List<PaymentMsg> paymentMsgs = paymentMsgMapper.selectByExample(paymentMsgExample);

        if (null == paymentMsgs || paymentMsgs.size() == 0) {
            return;
        }

        for (PaymentMsg paymentMsg : paymentMsgs) {
            long orderId = paymentMsg.getOrderId();

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("http://localhost:8080/handleOrder");
            NameValuePair nameValuePair = new BasicNameValuePair("orderId", orderId + "");
            List<NameValuePair> list = new ArrayList<>();
            list.add(nameValuePair);

            HttpEntity httpEntity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse execute = httpClient.execute(httpPost);

            String s = EntityUtils.toString(execute.getEntity());

            if ("success".equals(s)) {
                paymentMsg.setStatus(1);
                paymentMsgMapper.updateByPrimaryKey(paymentMsg);
            } else {
                Integer failureCnt = paymentMsg.getFailureCnt();
                failureCnt++;
                if (failureCnt > 5) {
                    paymentMsg.setStatus(2);

                }
                paymentMsg.setFailureCnt(failureCnt);
                paymentMsgMapper.updateByPrimaryKey(paymentMsg);
            }
        }
    }
}
