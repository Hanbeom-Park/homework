package com.ssafy.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f;
	JPanel p;
	JButton b;
	JList<Object> li;
	JTextArea ta;
	INewsDAO dao;
	
	public NewsMain(){
		dao=new NewsDAOSAXImpl();
		createGUI();
		addEvent();
		showList();
	}
	//gui생성
	public void createGUI(){
		f=new JFrame("NewsList");
		p=new JPanel();
		b=new JButton("News List 호출");
		li=new JList<Object>();
		ta=new JTextArea("");
		ta.setLineWrap(true);		
		p.setLayout(new BorderLayout());
		p.add(b, "North");
		p.add(li);		
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);		
		f.setSize(400, 500);
		f.setVisible(true);
	}
	//이벤트 추가
	public void addEvent(){
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showList();				
			}			
		});
		li.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				News n=(News)li.getSelectedValue();
				ta.setText(n.getDesc());				
			}
		});
	}
	public void showList(){
		java.util.List<News>  datas=dao.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(datas.toArray());
	}
	public static void main(String[] args) {
		new NewsMain();
	}
}