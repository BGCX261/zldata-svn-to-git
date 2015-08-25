package com.zl.processing.dataVis;

import processing.core.PApplet;

/**
 * 方块
 * @author lyc557@163.com
 * 2013-2-21上午11:12:36
 */
public class Rec {

	PApplet p;
	float x0;
	float y0;
	float x1;
	float y1;
	float H;
	float B;
	float S = 80;
	float scale = (float) 0.2;// 这里基本不要去变

	Rec(float ix0, float iy0, float ix1, float iy1, float iH, PApplet ip) {
		x0 = ix0;
		y0 = iy0;
		x1 = ix1;
		y1 = iy1;
		H = iH;
		p = ip;
	}

	void setColor(int k) {
		if (k == 0) {
			B = 30;
			S = 60;
		}
		if (k == 1) {
			B = 100;
			S = 0;
		}
		if (k == 2) {
			B = 0;
			S = 0;
		}
	}

	void scalex() {
		float offset = (x1 - x0) * scale;
		x0 += offset;
		x1 -= offset;
	}// 沿着中心，x缩放

	void scalex(String l) {
		if (l == "10") {
			float offset = (x1 - x0) * scale;
			x0 += offset;
		}
		if (l == "01") {
			float offset = (x1 - x0) * scale;
			x1 -= offset;
		}
	}

	void scaley(String l) {
		float offset = (y1 - y0) * scale;
		if (l == "10") {
			y0 += offset;
		}
		if (l == "01") {
			y1 -= offset;
		}
	}

	void scaley(String l,float d) {
		float offset = d;
		if (l == "10") {y0 += offset;
		}
		if (l == "01") {
			y1 -= offset;
		}
	}
	
	void scaley() {
		float offset = (y1 - y0) * scale;
		y0 += offset;
		y1 -= offset;
	}

	void scale() {
		this.scalex();
		this.scaley();
	}

	void display() {
		p.noStroke();
		p.fill(H, S, B);
		p.rect(x0, y1, x1, y0);
	}// 构造函数
}