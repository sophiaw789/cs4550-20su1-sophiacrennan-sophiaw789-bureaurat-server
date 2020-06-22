package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query("SELECT admin FROM Admin admin WHERE admin.id=:uid")
    public Admin findAdminById(@Param("uid") Integer adminId);

    @Query("SELECT admin FROM Admin admin WHERE admin.username=:u")
    public Admin findAdminByUsername(@Param("u") String username);

    @Query("SELECT admin FROM Admin admin WHERE admin.username=:username AND admin.password=:password")
    public Admin findAdminByCredentials(@Param("username") String username, @Param("password") String password);
}
