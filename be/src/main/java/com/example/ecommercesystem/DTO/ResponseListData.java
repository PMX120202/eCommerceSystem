package com.example.ecommercesystem.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListData<T> extends ResponseClient{

    private List<T> data;

    public ResponseListData(int id, List<T> data){
        super(id);
        this.data = data;
    }
}
