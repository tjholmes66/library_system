package com.librarysystem.server.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.server.domain.RoleEntity;


public class RoleDaoImplTest extends BaseDaoTests
{
    @Autowired
    private RoleDao roleDao;

    protected void setUp() throws Exception
    {
        System.out.println("setup: Loading application context");
        System.out.println("setup: Done loading application context");
    }

    protected void tearDown() throws Exception
    {
        super.tearDown();
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
    }

    private long _roleId = 0;

    private String _roleName = "Name";
    private String _roleCode = "CODE";

    private long _editedBy = 1;
    private long _enteredBy = 1;
    private LocalDateTime _editedDate = LocalDateTime.now();
    private LocalDateTime _enteredDate = LocalDateTime.now();

    private RoleEntity create()
    {
        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRoleId(_roleId);

        roleEntity.setRoleCode(_roleCode);
        roleEntity.setRoleName(_roleName);

        roleEntity.setEditedBy(_editedBy);
        roleEntity.setEditedDate(_editedDate);
        roleEntity.setEnteredBy(_enteredBy);
        roleEntity.setEnteredDate(_enteredDate);

        return roleEntity;
    }

    // RoleEntity create(RoleEntity roleEntity);
    @Test
    public void testRoleCreate()
    {
        System.out.println("testRoleCreate: START");

        RoleEntity roleEntity = create();

        roleEntity = roleDao.create(roleEntity);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(_roleName, roleEntity.getRoleName());
        assertEquals(_roleCode, roleEntity.getRoleCode());

        System.out.println("testRoleCreate: FINISH");
    }

    // RoleEntity updateRoleEntity(RoleEntity roleEntity);
    @Test
    public void testRoleUpdate()
    {
        System.out.println("testRoleUpdate: START");

        RoleEntity roleEntity = create();

        roleEntity = roleDao.create(roleEntity);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(_roleName, roleEntity.getRoleName());
        assertEquals(_roleCode, roleEntity.getRoleCode());

        String rolename = "upd_name";
        String rolecode = "upd_code";
        roleEntity.setRoleName(rolename);
        roleEntity.setRoleCode(rolecode);

        roleEntity = roleDao.update(roleEntity);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(rolename, roleEntity.getRoleName());
        assertEquals(rolecode, roleEntity.getRoleCode());

        System.out.println("testRoleUpdate: FINISH");
    }

    // void deleteRoleEntity(long roleId);
    // void deleteRoleEntity(RoleEntity roleEntity);

    // RoleEntity getRoleEntity(long roleId);
    @Test
    public void testGetRoleEntityById()
    {
        System.out.println("testGetRoleEntity: START");

        RoleEntity roleEntity = create();

        roleEntity = roleDao.create(roleEntity);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(_roleName, roleEntity.getRoleName());
        assertEquals(_roleCode, roleEntity.getRoleCode());

        long roleId = roleEntity.getRoleId();
        roleEntity = roleDao.getById(roleId);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(_roleName, roleEntity.getRoleName());
        assertEquals(_roleCode, roleEntity.getRoleCode());

        System.out.println("testGetRoleEntity: FINISH");
    }

    // RoleEntity getRoleEntityByRolename(String rolename);
    @Test
    public void testGetRoleEntityByRoleCode()
    {
        System.out.println("testGetRoleEntityByRoleCode: START");

        RoleEntity roleEntity = create();

        roleEntity = roleDao.create(roleEntity);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(_roleName, roleEntity.getRoleName());
        assertEquals(_roleCode, roleEntity.getRoleCode());

        String roleCode = roleEntity.getRoleCode();
        roleEntity = roleDao.getRoleEntityByCode(roleCode);

        assertNotNull(roleEntity);
        assertNotSame(0, roleEntity.getRoleId());
        assertEquals(roleCode, roleEntity.getRoleCode());

        System.out.println("testGetRoleEntityByRoleCode: FINISH");
    }

    // List<RoleEntity> getAllRoleEntityList();
    @Test
    public void testGetAllRoleEntityList()
    {
        System.out.println("testGetAllRoleEntityList: START");

        List<RoleEntity> roleList = roleDao.getAllRoleEntityList();

        assertNotNull(roleList);
        assertEquals(true, roleList.size() > 0);

        System.out.println("testGetAllRoleEntityList: FINISH");
    }

}
