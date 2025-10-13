package com.example.digital_library.mapper;

import com.example.digital_library.domain.Organization;
import lombok.NonNull;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface OrganizationMapper {

    @Insert("INSERT INTO dl_organization (organization_uid, name) VALUES (#{organizationId,  jdbcType=OTHER}, #{name})")
    void addOrganization(@NonNull Organization organization);

    @Select("SELECT EXISTS(SELECT 1 FROM dl_organization WHERE LOWER(name) = LOWER(#{name}))")
    boolean existByName(@NonNull String name);

    @Select("SELECT * FROM dl_organization WHERE organization_uid = #{organizationUid}")
    @Results({
            @Result(column = "organization_uid", property = "organizationId", jdbcType = JdbcType.OTHER),
            @Result(column = "name", property = "name")
    })
    Organization findOrganizationByUid(@NonNull UUID organizationUuid);

    @Select("SELECT * FROM dl_organization WHERE name ILIKE CONCAT('%', #{namePart}, '%')")
    @Results({
            @Result(column = "organization_uid", property = "organizationId", jdbcType = JdbcType.OTHER),
            @Result(column = "name", property = "name")
    })
    List<Organization> findOrganizationsByPartialName(@NonNull String namePart);
}
