package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException {
		Library LB=new Library();
		LB.openApp("http://122.175.8.158/ranford2/");
		LB.AdminLgn("Admin", "M1ndq");
		LB.BranchCre("Branch99", "Address99", "Address991", "Address992", "Area99", "300078", "INDIA", "GOA", "GOA");
		LB.HomebtnClick();
		LB.RoleCrea("AssistantManagerr", "ManagerrDesc", "lstRtypeN");
		LB.HomebtnClick();
		LB.EmpCrtn("EmployeeeEmployee", "pwdpwd", "assistantmanager", "bridgeq");
		LB.CloseApp();
				
		
		

	}

}
