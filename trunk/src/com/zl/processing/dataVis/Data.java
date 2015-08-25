package com.zl.processing.dataVis;

/**
 * 数组
 * 
 * @author lyc557@163.com 2013-2-21上午11:10:36
 */
public class Data {
	float[][] d;
	int n;
	float maxy;
	float maxx;
	int m;// (是不是多维的表格)

	Data(float[][] idata) {// 构造函数
		d = idata;
		n = d.length;
		maxx = d[n - 1][0];
		maxy = d[0][1];
		for (int k = 0; k < n; k++) {
			if (d[k][1] > maxy) {
				maxy = d[k][1];
			}
		}
	}
	
}