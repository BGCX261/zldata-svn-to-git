package com.zl.processing.dataVis;

import processing.core.PApplet;

/**
 * ����
 * @author lyc557@163.com
 * 2013-2-21����11:15:17
 */
public class Column {// data��2Ԫ���飬��{{1,8},{2,6},{3,33}.....{x,y}}

	PApplet p;

	Grid g;
	float columnText = 0;
	float x0;
	float y0;
	float x1;
	float y1;
	float[][] d;
	float maxy;
	float maxx;
	int n;

	float H;
	float S = 0;
	float B = 110;
	float scale = (float) 0.5;
	float scale1=(float) 0.1;
    boolean colorMode=false;

	Column(Grid ig) {

		g = ig;
		p = g.p;
		x0 = g.r.x0;
		y0 = g.r.y0;
		x1 = g.r.x1;
		y1 = g.r.y1;
		maxy = g.maxy;
		maxx = g.maxx;
		n = g.n;
		d = g.d.d;
	}
	

	void display(String l) {
		float du = 0;
		float dv = 0;
		float dU = 0;
		float dV = 0;
		float datau = 0;
		float datav = 0;
		p.rectMode(p.CORNERS);
		p.noStroke();
		p.textAlign(0, 0);

		if (l == "x") {
			du = (x1 - x0) / (n + 1);
			dv = -(y1 - y0) / (maxy);
		}
		if (l == "y") {
			du = -(y1 - y0) / (n + 1);
			dv = (x1 - x0) / (maxy);
		}
		
		
		
       if (!colorMode){
    	   p.stroke(100,0,0);
       }
       
       
		for (int i = 0; i < n; i++) {
			datau = d[i][0];
			datav = d[i][1];
			dU = (i + 1) * du;
			dV = datav * dv;
			
			
            if (colorMode){
			float jit = (float) 0.2;// jit��ż���������п�����ɫ����������
			float s;
			float b;
			if (i % 2 == 0) {
				s = S * (1 + jit);
				b = B / (1 + 2 * jit);
			} else {
				s = S / (1 + 2 * jit);
				b = B * (1 + jit);
			}
			p.fill(H, s, b);}
			
            
            
            float textSize = Math.abs(du);
            p.textFont(p.createFont("MicrosoftYaHei-Bold", (int) textSize));//////���ʹ�ô���
			if (l == "x") {
				float xx = x0 + dU;
				float yy = y1 + dV;
				float xx1=xx - du * scale;
				p.rect(xx, yy, xx1, y1, 5, 5, 0, 0);

				if(n<20){
				p.fill(0, 0, B);
				p.text(datau, xx - du * scale, y1 + dV);//��״ͼͷ�������ֱ�ע n�Ƚ�Сʱ�������
				}
			}

			if (l == "y") {
				float xx = x0;
				float yy = y1 + dU;
				float xx1 = xx + dV;
				float yy1 = yy - du * scale;
				p.rect(xx, yy, xx1, yy1, 0, 0, 0, 0);
				
				//if (columnText == 1) {
					//p.fill(0, 0, B);
					//int tags = (int) v;
					//p.text(tags,xx1+dV*scale1,yy1-dU*scale1);
				//}
				
				p.fill(0, 0, B);
				p.text(datav,xx1,yy1);//�����޸�����ʹ�����ֶ��뷽ʽ�仯
				
				float textSize1=(float) (textSize*scale*1.0);
				p.textFont(p.createFont("AngsanaNew-BoldItalic", textSize1));
				String tag1=""+datau;
				int len=tag1.length();
				//p.print(dv+"==");
				float xx3=xx-len*textSize1;
				p.text(tag1,xx3,yy1);

			}

		}

	}
}
