package common;

import java.util.ArrayList;

import model.bean.Ghe;

public class Convert {
	public ArrayList<ArrayList<Ghe>> convertArrToMatrix(ArrayList<Ghe> listGheArr)
	{
		ArrayList<ArrayList<Ghe>>listMatrixGhe = new ArrayList<ArrayList<Ghe>>();
		
		int rowMax=0,colmax=0;
		for(int i=0;i< listGheArr.size();i++)
		{
			if(listGheArr.get(i).getVtHang()>rowMax)
				rowMax = listGheArr.get(i).getVtHang();
			if(listGheArr.get(i).getVtCot()>colmax)
				colmax = listGheArr.get(i).getVtCot();
		}
		Ghe[][] t_matrix_list = new Ghe[rowMax+1][colmax+1];
		
		for(int i=0;i<listGheArr.size();i++)
		{
			//(listGheArr.get(i).getTang()==1)
			//{
				t_matrix_list[listGheArr.get(i).getVtHang()][listGheArr.get(i).getVtCot()] = listGheArr.get(i);
			//}
		}
		for(int i=1;i<t_matrix_list.length;i++)
		{
			ArrayList<Ghe> t_arr_l = new ArrayList<Ghe>();
			for(int j=1;j<t_matrix_list[0].length;j++)
			{
				//try {
				System.out.println(i);
				if(t_matrix_list[i][j]!=null)
					t_arr_l.add(t_matrix_list[i][j]);
				//}
				//catch(Exception ex)
				//{
				//	System.out.println(ex.getMessage());
				//}
			}
			listMatrixGhe.add(t_arr_l);
		}
		return listMatrixGhe;
	}
	public ArrayList<Ghe> convertMatrixToChairArr(ArrayList<ArrayList<Ghe>> matrixGhe)
	{
		ArrayList<Ghe> listGhe = new ArrayList<Ghe>();
		for(int i=0;i<matrixGhe.size();i++)
		{
			for(int j=0;j<matrixGhe.get(i).size();j++)
			{
				Ghe ghe = new Ghe(matrixGhe.get(i).get(j).getVtHang(), matrixGhe.get(i).get(j).getVtCot(), matrixGhe.get(i).get(j).getTrangThai(), matrixGhe.get(i).get(j).getTang());
				ghe.setDay(matrixGhe.get(i).get(j).getDay());
				
				listGhe.add(ghe);
			}
		}
		return listGhe;
	}
}
