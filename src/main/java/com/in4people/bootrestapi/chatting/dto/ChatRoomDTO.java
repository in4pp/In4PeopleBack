
public class ChatRoomDTO {

    private int roomnb; //채팅방 순서

    private String roomname; // 채팅방 이름

    private  long user count; // 채팅방 인원수

    private HashMap<String, String> userlist = new HashMap<String, String>();

    public ChaatRoom create(String roomname) {
        ChatRoom chatRoom = new ChatRoom();
        chatroomnb.roomnb = UUID.randomUUID().toString();
        chatRoom.roomnb = roomNb;

        return chatRoom
    }
}