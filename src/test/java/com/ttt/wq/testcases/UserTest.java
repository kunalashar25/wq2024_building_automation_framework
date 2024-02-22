package com.ttt.wq.testcases;

import org.testng.annotations.Test;
import com.ttt.wq.utils.LogHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class UserTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Add User Details")
    @Epic("User Details")
    @Feature("Adding User")
    public void addNewUser() {
        LogHelper.getLogger().info("inside addNewUser");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit User Profile")
    @Epic("User Details")
    @Feature("Editing User")
    public void editUserProfile() {
        LogHelper.getLogger().info("inside editUserProfile");
    }
}
