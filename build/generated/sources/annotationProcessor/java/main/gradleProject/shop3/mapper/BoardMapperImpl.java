package gradleProject.shop3.mapper;

import gradleProject.shop3.domain.Board;
import gradleProject.shop3.dto.BoardDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-07T17:41:53+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board toEntity(BoardDto boardDto) {
        if ( boardDto == null ) {
            return null;
        }

        Board board = new Board();

        board.setNum( boardDto.getNum() );
        board.setBoardid( boardDto.getBoardid() );
        board.setWriter( boardDto.getWriter() );
        board.setPass( boardDto.getPass() );
        board.setTitle( boardDto.getTitle() );
        board.setContent( boardDto.getContent() );
        board.setRegdate( boardDto.getRegdate() );
        board.setReadcnt( boardDto.getReadcnt() );
        board.setGrp( boardDto.getGrp() );
        board.setGrplevel( boardDto.getGrplevel() );
        board.setGrpstep( boardDto.getGrpstep() );
        board.setCommentCnt( boardDto.getCommentCnt() );

        return board;
    }

    @Override
    public BoardDto toDto(Board board) {
        if ( board == null ) {
            return null;
        }

        BoardDto boardDto = new BoardDto();

        boardDto.setFileurl( board.getFileurl() );
        boardDto.setNum( board.getNum() );
        boardDto.setBoardid( board.getBoardid() );
        boardDto.setWriter( board.getWriter() );
        boardDto.setPass( board.getPass() );
        boardDto.setTitle( board.getTitle() );
        boardDto.setContent( board.getContent() );
        boardDto.setRegdate( board.getRegdate() );
        boardDto.setReadcnt( board.getReadcnt() );
        boardDto.setGrp( board.getGrp() );
        boardDto.setGrplevel( board.getGrplevel() );
        boardDto.setGrpstep( board.getGrpstep() );
        boardDto.setCommentCnt( board.getCommentCnt() );

        return boardDto;
    }
}
