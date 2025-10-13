package com.example.digital_library.mapper;

import com.example.digital_library.domain.Organization;
import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface OrganizationMapper {

    @Insert("INSERT INTO dl_organization (organization_uid, name) VALUES (#{organizationId,  jdbcType=OTHER}, #{name})")
    void addOrganization(@NonNull Organization organization);

    @Select("SELECT EXISTS(SELECT 1 FROM dl_organization WHERE LOWER(name) = LOWER(#{name}))")
    boolean existByName(@NonNull String name);

    @Select("SELECT * FROM dl_organization WHERE organization_uid = #{organizationUid}")
    Optional<Organization> findOrganizationByUid(@NonNull UUID organizationUuid);

    @Select("SELECT * FROM dl_organization WHERE name ILIKE '%' || #{namePart} || '%'")
    List<Organization> findOrganizationsByNamePart(@NonNull String namePart);
}
