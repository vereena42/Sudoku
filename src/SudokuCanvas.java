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

import java.awt.*;

public class SudokuCanvas extends Canvas{
    SudokuBoard sudokuBoard;
    public SudokuCanvas() {
        setPreferredSize(new Dimension(300, 300));
        setMinimumSize(new Dimension(300, 300));
    }

    public void paint(Graphics g)
    {
        int val;
        int n=sudokuBoard.getSize();
        int x=(290-10)/n;
        int y=x;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(sudokuBoard.isConflicted(i,j))
                {
                    g.setColor(Color.red);
                    g.fillRect(10+j*x,10+i*x,x,x);
                }
            }
        }
        g.setColor(Color.black);
        g.drawLine(10,10,290,10);
        g.setColor(Color.black);
        g.drawLine(10,10,10,290);
        g.setColor(Color.black);
        g.drawLine(290,10,290,290);
        g.setColor(Color.black);
        g.drawLine(10,290,290,290);
        while(x<290)
        {
            g.setColor(Color.black);
            g.drawLine(10,10+x,290,10+x);
            g.setColor(Color.black);
            g.drawLine(10+x,10,10+x,290);
            x+=y;
        }
        for(int i=0;i<n;i++)
        {
            if(sudokuBoard.getAreaNumber(0,i)!=0)
            {
                ((Graphics2D)g).setStroke(new BasicStroke(5));
                g.setColor(Color.black);
                g.drawLine(10+i*y,10,10+(i+1)*y,10);
            }
            if(sudokuBoard.getAreaNumber(i,0)!=0)
            {
                ((Graphics2D)g).setStroke(new BasicStroke(5));
                g.setColor(Color.black);
                g.drawLine(10,10+i*y,10,10+(i+1)*y);
            }
            if(sudokuBoard.getAreaNumber(n-1,i)!=0)
            {
                ((Graphics2D)g).setStroke(new BasicStroke(5));
                g.setColor(Color.black);
                g.drawLine(10+i*y,290,10+(i+1)*y,290);
            }
            if(sudokuBoard.getAreaNumber(i,n-1)!=0)
            {
                ((Graphics2D)g).setStroke(new BasicStroke(5));
                g.setColor(Color.black);
                g.drawLine(290,10+i*y,290,10+(i+1)*y);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j!=0)
                {
                    if(sudokuBoard.getAreaNumber(i,j)!=sudokuBoard.getAreaNumber(i,j-1))
                    {
                        ((Graphics2D)g).setStroke(new BasicStroke(5));
                        g.setColor(Color.black);
                        g.drawLine(10+j*y,10+i*y,10+j*y,10+(i+1)*y);
                    }
                }
                if(i!=0)
                {
                    if(sudokuBoard.getAreaNumber(i,j)!=sudokuBoard.getAreaNumber(i-1,j))
                    {
                        ((Graphics2D)g).setStroke(new BasicStroke(5));
                        g.setColor(Color.black);
                        g.drawLine(10+j*y,10+i*y,10+(j+1)*y,10+i*y);
                    }
                }
                val=sudokuBoard.getValue(i,j);
                if(val!=0) {
                    if (sudokuBoard.isHardcoded(i, j))
                        g.setFont(new Font("font", Font.BOLD, y/2));
                    else
                        g.setFont(new Font("font", 0, y / 2));
                    g.drawString(((Integer) val).toString(), 10 + j * y+y/3, 10 + i * y +2*y/3);
                }
            }
        }
    }
    public void setSudokuBoard(SudokuBoard sudokuBoard)
    {
        this.sudokuBoard=sudokuBoard;
    }
}
