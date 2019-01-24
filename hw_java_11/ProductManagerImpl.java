package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;




public class ProductManagerImpl implements IProductMgr{

	private static ProductManagerImpl productImpl;
	private ProductManagerImpl() {
	}
	public static ProductManagerImpl getInstance() {
		if(productImpl==null) {
			productImpl=new ProductManagerImpl();
		}
		return productImpl;
	}
	//---------------------위 싱글턴
	private ArrayList<Product> products=new ArrayList<>();
	private ArrayList<Member> members =new ArrayList<>();
	private ArrayList<Sale> sales =new ArrayList<>();
	//-----------------------
	private int memberKey,productKey,saleKey;
	@Override
	public boolean addMember(Member b) {
		b.setId(Integer.toString(memberKey++));
		members.add(b);
		
		return true;
	}
	@Override
	public Member findMemberById(String id) {
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getId().equals(id)) {
				return members.get(i);
			}
		}
		try {
			throw new CodeNotFoundException();
		} catch (CodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Member> findMember(){
		return members;
	}
	@Override
	public ArrayList<Member> findMemberByName(String name) {
		ArrayList<Member> hh=new ArrayList<>();
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getName().equals(name)) {
				hh.add(members.get(i));
			}
		}
		return hh;
	}
	@Override
	public Member updateMember(String id, Member b) {
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getId().equals(id)) {
				b.setId(members.get(i).getId());
				members.set(i, b);
				return members.get(i);
			}
		}
		return null;
	}
	@Override
	public boolean removeMember(String id) {
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).getId().equals(id)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	//------- ProductManagerImpl <> -----> Product  aggregation
	public void addAll(ArrayList<Product> p) {
		products=p;
	}
	@Override
	public void add(Product product) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(product.getName())) {
				try {
					throw new DuplicateException();
				} catch (DuplicateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return;
			}
		}
		product.setNo(Integer.toString(productKey++));
		products.add(product);
		
	}
	@Override
	public ArrayList<Product> findAll() {

		return products;
	}
	@Override
	public Product findByNo(String no) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getNo().equals(no)) {
				return products.get(i);
			}
		}
		try {
			throw new CodeNotFoundException();
		} catch (CodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<Product> findByName(String name) {

		ArrayList<Product> hh=new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().equals(name)) {
				hh.add(products.get(i));
			}
		}

		return hh;
	}
	@Override
	public ArrayList<TV> findOnlyTV() {
		ArrayList<TV> hh=new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				hh.add((TV) products.get(i));
			}
		}

		return hh;
	}
	@Override
	public ArrayList<Refrigerator> findOnlyRefrigerators() {
		ArrayList<Refrigerator> hh=new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				hh.add((Refrigerator) products.get(i));
			}
		}

		return hh;
	}
	@Override
	public ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) {
		Refrigerator aa;
		ArrayList<Refrigerator> hh=new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				aa=(Refrigerator)products.get(i);
				if(aa.getCapacity()>capacity) {
					hh.add(aa);
				}
			}
		}
		if(hh.size()==0) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hh;
	}
	@Override
	public ArrayList<TV> findByAboveTV(int wide) {
		TV aa;
		ArrayList<TV> hh=new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				aa=(TV)products.get(i);
				if(aa.getWide()>wide) {
					hh.add(aa);
				}
			}
		}
		if(hh.size()==0) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hh;
	}
	@Override
	public void updateProduct(String no, int price) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getNo().equals(no)) {
				products.get(i).setPrice(price);
				break;
			}
		}
	}
	@Override
	public void deleteProduct(String no) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getNo().equals(no)) {
				products.remove(i);
			}
		}
	}
	@Override
	public long booksTotalPrice() {
		int tot=0;
		for (int i = 0; i < products.size(); i++) {
			tot=tot+products.get(i).getPrice();
		}
		return tot;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return products.size();
	}
	@Override
	public boolean addSale(Sale b) {
		b.setSeq(saleKey++);
		sales.add(b);
		return true;
	}
	@Override
	public ArrayList<Sale> findSaleById(String id) {
		ArrayList<Sale> hh=new ArrayList<>();
		for (int i = 0; i < sales.size(); i++) {
			if(sales.get(i).getId().equals(id)) {
				hh.add(sales.get(i));
			}
		}
		return hh;
	}
	@Override
	public ArrayList<Sale> findSaleByNo(String no) {
		ArrayList<Sale> hh=new ArrayList<>();
		for (int i = 0; i < sales.size(); i++) {
			if(sales.get(i).getNo().equals(no)) {
				hh.add(sales.get(i));
			}
		}
		return hh;	
	}
	@Override
	public long TotalSales() {
		
		//
		int tot=0;
		for (int i = 0; i < sales.size(); i++) {
			tot=tot+findByNo(sales.get(i).getNo()).getPrice()*sales.get(i).getHowmany();
		}
		return tot;
	}
	@Override
	public boolean removeSale(int seq) {
		for (int i = 0; i < sales.size(); i++) {
			if(sales.get(i).getSeq()==seq) {
				sales.remove(i);
			}
		}
		return false;
	}
	@Override
	public ArrayList<Sale> findAllSale() {
		// TODO Auto-generated method stub
		return sales;
	}
	public void saveObj(String fname,ArrayList<Product> sts) {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		int count=sts.size();
		try {
			fos=new FileOutputStream(fname,false);
			oos=new ObjectOutputStream(fos);
			oos.writeInt(count);
			int k=0;
			for (Product s:sts) {
				oos.writeInt(k++);
				oos.writeObject(s);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public ArrayList<Product> readObj(String fname){
		
		ArrayList<Product> sts=new ArrayList<>();
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(fname);
			ois=new ObjectInputStream(fis);
			int count=ois.readInt();
			for (int i = 0; i < count; i++) {
				int k=ois.readInt();
				Product ss=(Product)ois.readObject();
				sts.add(ss);
			}
			addAll(sts);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sts;
	}
	@Override
	public void open() {
		String fname = "product.dat";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(msg, "|");
				int kind = Integer.parseInt(st.nextToken().trim());
				if (kind == 1) {
					this.add(new TV(st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				} else {
					this.add(new Refrigerator(st.nextToken().trim(), Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		}
	}

	@Override
	public void close() {
		String fname = "product.dat";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fname, false), true);

			for (int i = 0; i < products.size(); i++) {
				Product b = products.get(i);
				String msg;
				if (b instanceof TV) {
					msg = String.format("%d%s%s%s%d%s%d%s%d", 1, "|", b.getName(), "|", b.getPrice(), "|",
							b.getAmount(), "|", ((TV) b).getWide());

				} else {
					msg = String.format("%d%s%s%s%d%s%d%s%d", 2, "|", b.getName(), "|", b.getPrice(), "|",
							b.getAmount(), "|", ((Refrigerator)b).getCapacity());
				}
				//System.out.println(msg);
				pw.println(msg);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}
}
