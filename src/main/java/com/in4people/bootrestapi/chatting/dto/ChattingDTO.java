
public class ChattingDTO {

    public enum MessageType {
        ENTER , TALK , LEAVE;
    }

    private MesssageType type; // 메시지 타입
    private String chatroomnumber; //방 번호
    private String sendnick; //채팅을 보낸 사람

    private String chatcontent; //채팅내용

    private String time; // 채팅 발송 시간

    private int chatreadchk; //채팅 읽음 유무
}