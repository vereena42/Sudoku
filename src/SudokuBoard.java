/*
	Copyright (c) 2015, Dominika Salawa <vereena42@gmail.com>
	All rights reserved.

	Redistribution and use in source and binary forms, with or without
	modification, are permitted provided that the following conditions are met:

		* Redistributions of source code must retain the above copyright notice,
		  this list of conditions and the following disclaimer.

		* Redistributions in binary form must reproduce the above copyright notice,
		  this list of conditions and the following disclaimer in the documentation
		  and/or other materials provided with the distribution.

		* Neither the name of the <organization> nor the names of its
		  contributors may be used to endorse or promote products derived from this
		  software without specific prior written permission.

	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
	ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
	DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY DIRECT,
	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
	BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
	DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
	LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
	OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
	ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.util.LinkedList;
import java.util.List;

public class SudokuBoard implements PropertyChangeListener{
    SudokuCanvas sudokuCanvas;
    private int n;
    private int [][] conflicted;
    private FieldBean [][] arr;
    private List<List<Pair>> areas;
    private VetoHardcoded vetoHardcoded=new VetoHardcoded(this);
    private VetoWrongAgrument vetoWrongAgrument=new VetoWrongAgrument(this);
    SudokuBoard(int n,int [][]arr,List<List<Pair>> list){
        int [][] temporary=new int[n][n];
        conflicted=new int[n][n];
        int val=1;
        for(List<Pair> x:list)
        {
            for(Pair y:x)
            {
                temporary[y.getX()][y.getY()]=val;
            }
            val++;
        }
        areas=list;
        this.arr=new FieldBean[n][n];
        FieldBean temp;
        this.n=n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(arr[i][j]!=0) {
                    temp=new FieldBean(i,j,arr[i][j],temporary[i][j]);
                    temp.addVetoableChangeListener(vetoHardcoded);
                    temp.addVetoableChangeListener(vetoWrongAgrument);
                    temp.addPropertyChangeListener(this);
                    this.arr[i][j] = temp;
                }
                else {
                    temp=new FieldBean(i,j,temporary[i][j]);
                    temp.addVetoableChangeListener(vetoHardcoded);
                    temp.addVetoableChangeListener(vetoWrongAgrument);
                    temp.addPropertyChangeListener(this);
                    this.arr[i][j]=temp;
                }
            }
        }
    }
    public void setField(int i,int j,int val) throws PropertyVetoException {
        arr[i][j].setValue(val);
    }
    public int getValue(int i,int j)
    {
        return arr[i][j].getValue();
    }
    public List<Pair> getArea(int i)
    {
        if(i==0)
            return new LinkedList<Pair>();
        return areas.get(i-1);
    }
    public int getAreaNumber(int i,int j)
    {
        return arr[i][j].getArea();
    }
    public boolean isHardcoded(int i,int j) { return arr[i][j].isHardcoded();}
    public int getSize(){
        return n;
    }

    public void addCanvas(SudokuCanvas sudokuCanvas) {
        this.sudokuCanvas=sudokuCanvas;
    }

    public boolean isConflicted(int x,int y){
        if(conflicted[x][y]==0)
            return false;
        return true;
    }

    private void checkIfConflicted(int x,int y)
    {
        conflicted[x][y]=0;
        if(arr[x][y].getValue()!=0) {
            for (int i = 0; i < n; i++) {
                if (i != x && arr[i][y].getValue() == arr[x][y].getValue()) {
                    conflicted[i][y] = 1;
                    conflicted[x][y] = 1;
                }
                if (i != y && arr[x][i].getValue() == arr[x][y].getValue()) {
                    conflicted[x][i] = 1;
                    conflicted[x][y] = 1;
                }
            }
            int num = arr[x][y].getArea();
            if(num>0) {
                for (Pair p : areas.get(num - 1)) {
                    if ((p.getX() != x || p.getY() != y) && arr[p.getX()][p.getY()].getValue() == arr[x][y].getValue()) {
                        conflicted[p.getX()][p.getY()] = 1;
                        conflicted[x][y] = 1;
                    }
                }
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        FieldBean s=(FieldBean)evt.getSource();
        int old=(Integer)evt.getOldValue();
        int x=s.getX();
        int y=s.getY();
        if(conflicted[x][y]==1) {
            for(int i=0;i<n;i++)
            {
                if(arr[i][y].getValue()==old)
                {
                    checkIfConflicted(i,y);
                }
                if(arr[x][i].getValue()==old)
                {
                    checkIfConflicted(x,i);
                }
            }
            int num=s.getArea();
            if(num>0) {
                for (Pair p : areas.get(num - 1)) {
                    if (arr[p.getX()][p.getY()].getValue() == old) {
                        checkIfConflicted(p.getX(), p.getY());
                    }
                }
            }
        }
        checkIfConflicted(x,y);
        sudokuCanvas.repaint();
    }
}
