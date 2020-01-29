package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import axs.CompanyAxs;
import biz.Company;
import mtc.CompanyMatcher;

public class CompanyAxsTester {
	final static Performer[] perfs= {
			()->testFetchAll(),
			()->testFetchBy(),
			()->testAdd(),
			()->testUpdate()
	};
	public static void performTests(int indexes[]) {
		for(int i:indexes) {
			try {
			System.out.println(perfs[i].perform()?"OK :-)":"KO :-(");
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	public static void main(String args[]) {
		performTests(new int[]{3});
	}
	public static boolean testUpdate() {
		CompanyAxs cax=CompanyAxs.getUniqueInstance();
		Company co1=new Company();
		long lind=new Date().getTime();
		co1.setName("Alter Solutions."+lind);
		co1.setDescription("A very good consulting company for IT and other sectors");
		co1.setFoundingDate(LocalDate.of(2006, 3, 1));
		co1.setSubscriptionDate(LocalDate.now());
		if(cax.add(co1)) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			co1.setName("Alter Solutionz."+lind);
			co1.setDescription("An excellent consulting company for IT and other sectors");
			co1.setFoundingDate(LocalDate.of(2006, 4, 1));
			co1.setSubscriptionDate(LocalDate.now());
			return cax.update(co1);
		}
		return false;
	}
	public static boolean testFetchBy() {
		CompanyAxs cax=CompanyAxs.getUniqueInstance();
		Company co1=new Company();
		long lind=new Date().getTime();
		co1.setName("Alter Solutions."+lind);
		co1.setDescription("A very good consulting company for IT and other sectors");
		co1.setFoundingDate(LocalDate.of(2006, 3, 1));
		co1.setSubscriptionDate(LocalDate.now());

		Company co2=new Company();
		co2.setName("IBM."+lind);
		co2.setDescription("Famous IT company");
		co2.setFoundingDate(LocalDate.of(1911, 6, 16));
		co2.setSubscriptionDate(LocalDate.now());
		
		Company co3=new Company();
		co3.setName("Google."+lind);
		co3.setDescription("Great IT company");
		co3.setFoundingDate(LocalDate.of(1998, 2, 21));
		co3.setSubscriptionDate(LocalDate.now());

		boolean ok=true;
		for(Company c:new Company[]{co1,co2,co3}){
			ok=ok && cax.add(c);
		}
		if(ok) {
			Map<CompanyMatcher,Object> crit=new HashMap<>();
//			crit.put(CompanyMatcher.AGE, co1.getAge());
			crit.put(CompanyMatcher.DESCRIPTION, co3.getDescription());
//			crit.put(CompanyMatcher.NAME,co3.getName());
			final List<Company> cList=cax.fetchBy(crit);
			if(cList==null) {
				return false;
			}else {
				cList.stream().forEach((c)->{
					System.out.println("===============");
					System.out.println("COMPANY ID:"+c.getId());
					System.out.println("COMPANY NAME:"+c.getName());
					System.out.println("COMPANY DESCRIPTION:"+c.getDescription());
					System.out.println("COMPANY AGE:"+c.getAge());
					System.out.println("COMPANY FOUNDING DATE:"+c.getFoundingDate());
					System.out.println("COMPANY SUBSCRIPTION DATE:"+c.getSubscriptionDate());
				});
				return true;
			}
		}
		return false;
	}
	public static boolean testFetchAll() {
		CompanyAxs cax=CompanyAxs.getUniqueInstance();
		Company co1=new Company();
		long lind=new Date().getTime();
		co1.setName("Alter Solutions."+lind);
		co1.setDescription("A very good consulting company for IT and other sectors");
		co1.setFoundingDate(LocalDate.of(2006, 3, 1));
		co1.setSubscriptionDate(LocalDate.now());

		Company co2=new Company();
		co2.setName("IBM."+lind);
		co2.setDescription("Famous IT company");
		co2.setFoundingDate(LocalDate.of(1911, 6, 16));
		co2.setSubscriptionDate(LocalDate.now());
		
		Company co3=new Company();
		co3.setName("Google."+lind);
		co3.setDescription("Great IT company");
		co3.setFoundingDate(LocalDate.of(1998, 2, 21));
		co3.setSubscriptionDate(LocalDate.now());

		boolean ok=true;
		for(Company c:new Company[]{co1,co2,co3}){
			ok=ok && cax.add(c);
		}
		if(ok) {
			final List<Company> cList=cax.fetchAll();
			if(cList==null) {
				return false;
			}else {
				cList.stream().forEach((c)->{
					System.out.println("===============");
					System.out.println("COMPANY ID:"+c.getId());
					System.out.println("COMPANY NAME:"+c.getName());
					System.out.println("COMPANY DESCRIPTION:"+c.getDescription());
					System.out.println("COMPANY AGE:"+c.getAge());
					System.out.println("COMPANY FOUNDING DATE:"+c.getFoundingDate());
					System.out.println("COMPANY SUBSCRIPTION DATE:"+c.getSubscriptionDate());
				});
				return true;
			}
		}
		return false;
	}
	public static boolean testAdd() {
		CompanyAxs cax=CompanyAxs.getUniqueInstance();
		Company co1=new Company();
		long lind=new Date().getTime();
		co1.setName("Alter Solutions."+lind);
		co1.setDescription("A very good consulting company for IT and other sectors");
		co1.setFoundingDate(LocalDate.of(2006, 3, 1));
		co1.setSubscriptionDate(LocalDate.now());

		Company co2=new Company();
		co2.setName("IBM."+lind);
		co2.setDescription("Famous IT company");
		co2.setFoundingDate(LocalDate.of(1911, 6, 16));
		co2.setSubscriptionDate(LocalDate.now());
		
		Company co3=new Company();
		co3.setName("Google."+lind);
		co3.setDescription("Great IT company");
		co3.setFoundingDate(LocalDate.of(1998, 2, 21));
		co3.setSubscriptionDate(LocalDate.now());

		boolean ok=true;
		for(Company c:new Company[]{co1,co2,co3}){
			ok=ok && cax.add(c);
		}
		if(ok) {
			Map<CompanyMatcher, Object> critz=new HashMap<>();
			critz.put(CompanyMatcher.NAME, "ALTER SOLUTIONS."+lind);
			List<Company> cList=cax.fetchBy(critz);
			return cList!=null && cList.size()>0;
		}
		return false;
	}
}
