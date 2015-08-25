package com.zl.processing.dataVis;
import processing.core.PApplet;

/**
 * ����
 * @author lyc557@163.com
 * 2013-2-21����11:14:19
 */
public class Grid {

	PApplet p;

	Rec r;
	float x0;
	float y0;
	float x1;
	float y1;

	Data d;
	float maxy;
	float maxx;
	int n;
	int B0;
	int B1;
	int B2;
	float scale = (float) 0.1;
	String colorStyle = "color";

	Grid( Rec ir, Data id,PApplet ip) {
		p = ip;
		r = ir; // x0=r.x0;y0=r.y0;x1=r.x1;y1=r.y1;
		d = id; // n=d.n;maxy=d.maxy;maxx=d.maxx;

		if (colorStyle == "color") {
			B0 = 90;
			B1 = 60;
			B2 = 100;
		}
		if (colorStyle == "white") {
			B0 = 30;
			B1 = 60;
			B2 = 10;
		}
	}

	void display(int k) {// ѡ����ʾ������ķ������
		boolean xdot = false;
		boolean ydot = false;
		boolean xaxis = false;
		boolean yaxis = false;

		if (k == 0) {
			xdot = true;
			xaxis = true;
		}
		if (k == 1) {
			xdot = true;
			xaxis = true;
		}
		if (k == 2) {
			xaxis = true;
		}
		if (k == 3) {
			yaxis = true;
		}

		float dd = 5;
		float l = dd * scale;
		float ddd = dd * scale;// ���߳���
		if (xdot == true) {// �����������ȱ䶯r ���Կ�����Ҫ֮���ٳ�ʼ��
			r.scaley("10");

			x0 = r.x0;
			y0 = r.y0;
			x1 = r.x1;
			y1 = r.y1;
			n = d.n;
			maxy = d.maxy;
			maxx = d.maxx;

			float wid = x1 - x0;
			float hei = y1 - y0;
			int nx = p.round(wid / dd);// ÿ�����ߵ�dot��
			int ny = 11;// y���10�� ͷ������
			float dy = hei / (float) ny;// ���߼��
			int textSize = (int) p.abs((float) (2.5 * dy * scale)) + 5;// ��ע����ߴ�
			float dt = 2 * scale * textSize;// ��ע���������ߵľ���
			p.textFont(p.createFont("MicrosoftYahei", textSize));

			for (int i = 0; i < nx; i++) {
				float x = x0 + i * dd;
				for (int j = 0; j < ny + 1; j++) {
					float y = y0 + j * dy;
					if (j < ny) {// �����ߣ�ż������ǿ
						if (j % 2 == 0) {
							p.stroke(0, 0, B0);
							p.strokeWeight(1);
						} else {
							p.stroke(0, 0, B1);
							p.strokeWeight(1);
						}
						p.line(x, y, x + ddd, y);
					}

					if ((i == 0) && (j % 2 == 0)) {// ��ż����������
						int tags = (int) ((1 - j / (float) ny) * maxy);
						p.fill(0, 0, B0);
						p.textAlign(0, 0);
						p.text(tags, x + dt, y - dt);
					}
				}
			}
		}

		if ((xaxis == true) || (yaxis == true)) {
			int c = p.color(0, 0, B0);

			r.scaley("10");
			x0 = r.x0;
			y0 = r.y0;
			x1 = r.x1;
			y1 = r.y1;
			n = d.n;
			maxy = d.maxy;
			maxx = d.maxx;

			float wid = x1 - x0;
			float nx = 10;
			float dx = wid / nx;
			p.strokeWeight(2);
			p.stroke(c);
			p.line(x0, y1, x1, y1);

			int textSize = (int) p.abs((float) (3.0 * dx * scale)) + 5;// ��ע����ߴ�
			float dt = 2 * scale * textSize;// ��ע���������ߵľ���

			for (int i = 0; i < nx + 1; i++) {
				float x = x0 + dx * i;
				float y = y1 + dx * scale * (float) 1.7;

				p.strokeWeight(1);
				p.stroke(c);
				p.line(x, y1, x, y);

				if (i % 2 == 0) {
					p.textFont(p.createFont("MicrosoftYahei", textSize));
					//float tags = (float)(p.round(100*i / (float) nx * (float) maxy))/100;
					String tags =10*i+"%";
					p.fill(c);
					p.textAlign(p.CENTER, 0);
					p.text(tags, x, y + dt + (float) (textSize * 0.8) + 2);
				}

			}

			// }

		}

	}

}
