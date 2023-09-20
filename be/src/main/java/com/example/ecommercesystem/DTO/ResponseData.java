package com.example.ecommercesystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> extends ResponseClient {
    private T data;

    public ResponseData(int id, T data){
        super(id);
        this.data = data;
    }
}
