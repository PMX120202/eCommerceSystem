package com.example.ecommercesystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage extends ResponseClient {
    private String message;

    public ResponseMessage(int id, String message){
        super(id);
        this.message = message;
    }
}
