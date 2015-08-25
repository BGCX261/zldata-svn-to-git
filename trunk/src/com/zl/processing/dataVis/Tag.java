package com.zl.processing.dataVis;
import processing.core.PApplet;

public class Tag {
		PApplet p;

		Rec r;
		float x0;
		float y0;
		float x1;
		float y1;

		String text;
		int n;
		int color;
		float scale = (float) 0.1;


		Tag( Rec ir, String itext,PApplet ip) {
			p = ip;
			r = ir; // x0=r.x0;y0=r.y0;x1=r.x1;y1=r.y1;
			text = itext; n=text.length();//maxy=d.maxy;maxx=d.maxx;
		}

		void display(String l) {// 选择显示坐标轴的方案序号
			

			if (l == "x") {
				r.scaley();
				x0=r.x0;y0=r.y0;x1=r.x1;y1=r.y1;
				float textSize=p.abs(y1-y0);
				p.textFont(p.createFont("AngsanaNew-BoldItalic", textSize));
				p.text(text,x0,y1);
			}
			if (l == "y") {				
				r.scalex();
			x0=r.x0;y0=r.y0;x1=r.x1;y1=r.y1;
			double textSize=p.abs(x1-x0)/(float)n;
			p.textFont(p.createFont("AngsanaNew-BoldItalic",  textSize));
			p.text(text,x0,y1);
			}
	}

}
