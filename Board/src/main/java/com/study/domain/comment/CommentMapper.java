package com.study.domain.comment;
///다음은 DB와의 통신 역할을 할 Mapper 인터페이스입니다.
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 댓글 저장
     * @param params - 댓글 정보
     */
    void save(CommentRequest params);

    /**
     * 댓글 상세정보 조회
     * @param id - PK
     * @return 댓글 상세정보
     */
    CommentResponse findById(Long id);

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     */
    void update(CommentRequest params);

    /**
     * 댓글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 댓글 리스트 조회
     * @param postId - 게시글 번호 (FK)
     * @return 댓글 리스트
     */
    List<CommentResponse> findAll(CommentSearchDto params);

    /**
     * 댓글 수 카운팅
     * @param postId - 게시글 번호 (FK)
     * @return 댓글 수
     */
    int count(CommentSearchDto params);

}