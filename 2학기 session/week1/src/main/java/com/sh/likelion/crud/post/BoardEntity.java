package com.sh.likelion.crud.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="board")
@Getter
@Setter
@NoArgsConstructor

public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement 느낌~,,, 새로운 레코드가 생길 때마다 자동으로 1씩 증가하도록 하겠다
    private Long id; //pk 같은 느낌으로 id를 쓰겠다

    private String name;

    @OneToMany( //board가 하나일 때 post가 여러 개다
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "boardEntity" //mappedBy로 board와 post가 연결이 되어있다
    )

    private List<PostEntity> postEntityList = new ArrayList<>();
}