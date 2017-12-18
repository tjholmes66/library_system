package com.librarysystem.server.dao;

import java.text.DecimalFormat;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath:/spring/librarysystem-dao-context.xml" })
@Transactional
@Ignore
public class BaseDaoTests extends TestCase
{
    public DecimalFormat _df = new DecimalFormat("#.00");
}
