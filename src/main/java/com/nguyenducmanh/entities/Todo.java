package com.nguyenducmanh.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Todo {
    int Id;
    String Title;
    short isCompleted;

    @Override
    public String toString() {
        return "Todo{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
