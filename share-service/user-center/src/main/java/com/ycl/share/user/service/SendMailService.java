package com.ycl.share.user.service;

/**
 * 发送邮箱
 */
public interface SendMailService {

    boolean sendMail(String toUser, String subject, String text);
}
