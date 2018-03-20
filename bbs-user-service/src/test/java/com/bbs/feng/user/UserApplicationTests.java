package com.bbs.feng.user;

import com.bbs.feng.coom.enums.RoleEnums;
import com.bbs.feng.user.entity.ActivationCodeEntity;
import com.bbs.feng.user.entity.PermissionEntity;
import com.bbs.feng.user.entity.RoleEntity;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.user.service.ActivationCodeService;
import com.bbs.feng.user.service.RoleService;
import com.bbs.feng.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
    private ActivationCodeService activationCodeService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void userSave(){
		UserEntity userEntity = new UserEntity();
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setCode(RoleEnums.ZSHY.getCode());
		roleEntity.setName(RoleEnums.ZSHY.getName());
		roleEntity.setDetail("管理员");
		roleEntity.setVideoNumber("&");
		RoleEntity role = roleService.saveRole(roleEntity);
		userEntity.setAccount("admin");
		userEntity.setE_mail("123456@gmail.con");
		userEntity.setName("管理员");
		userEntity.setPassword("123456");
		userEntity.setPhoneNumber("15900575334");
		userEntity.setRoles(role);

		UserEntity userEntity1 = userService.saveUser(userEntity);
		System.out.print(userEntity1);
	}

	@Test
	public void ct(){
		UserEntity userEntity = userService.findOneUserByAccount("admin");
		System.out.print(userEntity);
	}

    @Test
    public void aa(){
        activationCodeService.generateActivationCode();
    }

    @Test
    public void ab(){
        Page<ActivationCodeEntity> activationCodeEntities = activationCodeService.findAllActivationCode(0,20);
        List<ActivationCodeEntity> activationCodeEntities1 = activationCodeEntities.getContent();
        System.out.print(activationCodeEntities);
    }

}
