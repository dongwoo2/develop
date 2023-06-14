package com.study.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Getter
@AllArgsConstructor //전체 멤버변수를 필요로 하는 생성자를 생성해줌
//    public MessageDto(String message, String redirectUri, RequestMethod method, Map<String, Object> data) {
//        this.message = message;
//        this.redirectUri = redirectUri;
//        this.method = method;
//        this.data = data;
//    } 이러한 형태
public class MessageDto {

    private String message;                 //사용자에게 전달할 메시지
    private String redirectUri;             //리다이렉트URI
    private RequestMethod method;           //HTTP 요청 메서드
    private Map<String,Object> data;        //화면(View)으로 전달할 데이터(파라미터)
}