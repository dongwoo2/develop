
package com.study.domain.comment;
//다음으로 댓글 생성(INSERT)과 수정(UPDATE)에 사용할 요청 클래스를 생성해 볼 건데요. 댓글도 게시글과 마찬가지로
// 요청(Request)과 응답(Response)용 클래스를 분리해서 데이터를 처리합니다.
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequest {

    private Long id;           // 댓글 번호 (PK)
    private Long postId;       // 게시글 번호 (FK)
    private String content;    // 내용
    private String writer;     // 작성자

}