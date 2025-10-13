package com.example.digital_library.mapper;

import com.example.digital_library.domain.User;
import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface UserMapper {

    //@Insert("INSERT INTO dl_user (user_id, name, organization_id VALUES ()")


    @Select("SELECT * FROM dl_user WHERE user_uid = #{userUid}")
    Optional<User> findUserByUid(@NonNull UUID userUid);
}
