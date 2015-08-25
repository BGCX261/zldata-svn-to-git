package com.zl.processing.dataVis;
import processing.core.*;
import processing.pdf.*;
/**
 * app 程序入口
 * @author lyc557@163.com
 * 2013-2-21上午11:10:18
 */
public class Appmain extends PApplet {
	float[] Hs = { 0, 50, 85, 195, 332 };
	float[][] data;
	int ss;

	//data={{0,5},{1,9},{2,15},{3,25},{4,42},{5,25},{6,45},{7,57},{8,87},{9,67},{11,47}};
	// public static final String colorsStyle="color";

	public void setup() {
		//设置模式
		rectMode(CORNERS);
		//设置颜色
		colorMode(HSB, 360, 100, 100);
		//大小
		size(100, 600);
		//画图
		strokeCap(SQUARE);
	
	}
	
	
	public void draw() {
		ss=22;
		beginRecord(PDF, ss+".pdf");
		
		//生成数组
		float t = second();// int mm=7+second()%15;
		int mm = 15;
		data = new float[mm][2];
		for (int i = 0; i < mm; i++) {
			data[i][0] = (float) (i*0.1);
			data[i][1] = noise(i, t);
		}

		float H = Hs[4];// float H=Hs[(int)second()%10%5];//float H=second()*5;
		int style = 0;
		// int style=0;
		Data d = new Data(data);
		//设置背景
		background(0, 0, 100);
		//画方块
		Rec r = new Rec(100, 100, 700, 700, H, this);
		r.setColor(style);
		r.display();
		r.scale();
		r.H = H;
		//画坐标
		Grid g = new Grid( r, d,this);
		g.display(2);
		//g.r.scaley("01",2);
		//画竹子
		
		//Column c = new Column(g);
		//c.H = H;
		//c.B = 100;
		//c.display("x");

	}

	public void keyPressed(){save(ss+".jpg");
   endRecord();exit();}
	// 应用程序入口
}
