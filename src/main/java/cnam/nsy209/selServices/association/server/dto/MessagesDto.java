package cnam.nsy209.selServices.association.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.squareup.moshi.Json;

public class MessagesDto implements Serializable {

    /**
     * For checking version
     */
    private static final long serialVersionUID = 1L;

    @Json(name ="messages")
    private List<MessageDto> messages = new ArrayList<MessageDto>();

    /* getter and setter */

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    @Override
    public String toString(){
        String result ="{ ";
        for(MessageDto messageDto:messages){
            result += messageDto.toString()+" , ";
        }
        result = result.substring(0,result.length()-1);
        result +="}";
        return result;
    }
}