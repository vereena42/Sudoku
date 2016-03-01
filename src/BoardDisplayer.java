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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class BoardDisplayer {
    static List<SudokuBoard> boards=new LinkedList<SudokuBoard>();
    public static void addSudokus()
    {
        //adding first
        int [][]arr=new int[4][4];
        List<List<Pair>> lists=new LinkedList<List<Pair>>();

        arr[2][0]=1;
        arr[2][1]=2;
        arr[3][2]=3;

        for(int i=0;i<4;i++)
            lists.add(new LinkedList<Pair>());

        lists.get(0).add(new Pair(0,0));
        lists.get(0).add(new Pair(0,1));
        lists.get(0).add(new Pair(1,0));
        lists.get(0).add(new Pair(2,0));

        lists.get(1).add(new Pair(0,2));
        lists.get(1).add(new Pair(0,3));
        lists.get(1).add(new Pair(1,3));
        lists.get(1).add(new Pair(2,3));

        lists.get(2).add(new Pair(1,1));
        lists.get(2).add(new Pair(2,1));
        lists.get(2).add(new Pair(3,0));
        lists.get(2).add(new Pair(3,1));

        lists.get(3).add(new Pair(1,2));
        lists.get(3).add(new Pair(2,2));
        lists.get(3).add(new Pair(3,2));
        lists.get(3).add(new Pair(3,3));

        SudokuBoard board=new SudokuBoard(4,arr,lists);
        boards.add(board);
        //adding second

        arr=new int[5][5];

        arr[1][1]=1;
        arr[1][3]=2;
        arr[3][1]=4;
        arr[3][3]=3;

        lists=new LinkedList<List<Pair>>();
        for(int i=0;i<4;i++)
            lists.add(new LinkedList<Pair>());
        lists.get(0).add(new Pair(0,1));
        lists.get(0).add(new Pair(1,0));
        lists.get(0).add(new Pair(1,1));
        lists.get(0).add(new Pair(1,2));
        lists.get(0).add(new Pair(2,0));

        lists.get(1).add(new Pair(0,2));
        lists.get(1).add(new Pair(0,3));
        lists.get(1).add(new Pair(1,3));
        lists.get(1).add(new Pair(1,4));
        lists.get(1).add(new Pair(2,3));

        lists.get(2).add(new Pair(2,1));
        lists.get(2).add(new Pair(3,0));
        lists.get(2).add(new Pair(3,1));
        lists.get(2).add(new Pair(4,1));
        lists.get(2).add(new Pair(4,2));

        lists.get(3).add(new Pair(2,4));
        lists.get(3).add(new Pair(3,2));
        lists.get(3).add(new Pair(3,3));
        lists.get(3).add(new Pair(3,4));
        lists.get(3).add(new Pair(4,3));

        board=new SudokuBoard(5,arr,lists);
        boards.add(board);

        //adding third
        arr=new int[7][7];

        arr[0][1]=6;
        arr[0][5]=7;
        arr[1][0]=3;
        arr[1][2]=5;
        arr[1][4]=7;
        arr[1][6]=1;
        arr[2][1]=5;
        arr[2][5]=6;
        arr[3][3]=2;
        arr[4][1]=3;
        arr[4][5]=2;
        arr[5][0]=2;
        arr[5][2]=4;
        arr[5][4]=6;
        arr[5][6]=5;
        arr[6][1]=1;
        arr[6][5]=3;

        lists=new LinkedList<List<Pair>>();
        for(int i=0;i<7;i++)
            lists.add(new LinkedList<Pair>());
        lists.get(0).add(new Pair(0,0));
        lists.get(0).add(new Pair(1,0));
        lists.get(0).add(new Pair(1,1));
        lists.get(0).add(new Pair(1,2));
        lists.get(0).add(new Pair(1,3));
        lists.get(0).add(new Pair(2,0));
        lists.get(0).add(new Pair(2,2));

        lists.get(1).add(new Pair(0,1));
        lists.get(1).add(new Pair(0,2));
        lists.get(1).add(new Pair(0,3));
        lists.get(1).add(new Pair(0,4));
        lists.get(1).add(new Pair(0,5));
        lists.get(1).add(new Pair(0,6));
        lists.get(1).add(new Pair(1,5));

        lists.get(2).add(new Pair(1,4));
        lists.get(2).add(new Pair(1,6));
        lists.get(2).add(new Pair(2,3));
        lists.get(2).add(new Pair(2,4));
        lists.get(2).add(new Pair(2,5));
        lists.get(2).add(new Pair(2,6));
        lists.get(2).add(new Pair(3,5));

        lists.get(3).add(new Pair(2,1));
        lists.get(3).add(new Pair(3,0));
        lists.get(3).add(new Pair(3,1));
        lists.get(3).add(new Pair(3,2));
        lists.get(3).add(new Pair(3,3));
        lists.get(3).add(new Pair(3,4));
        lists.get(3).add(new Pair(4,0));

        lists.get(4).add(new Pair(3,6));
        lists.get(4).add(new Pair(4,4));
        lists.get(4).add(new Pair(4,5));
        lists.get(4).add(new Pair(4,6));
        lists.get(4).add(new Pair(5,6));
        lists.get(4).add(new Pair(6,5));
        lists.get(4).add(new Pair(6,6));

        lists.get(5).add(new Pair(4,1));
        lists.get(5).add(new Pair(4,2));
        lists.get(5).add(new Pair(5,0));
        lists.get(5).add(new Pair(5,1));
        lists.get(5).add(new Pair(5,2));
        lists.get(5).add(new Pair(6,0));
        lists.get(5).add(new Pair(6,1));

        lists.get(6).add(new Pair(4,3));
        lists.get(6).add(new Pair(5,3));
        lists.get(6).add(new Pair(5,4));
        lists.get(6).add(new Pair(5,5));
        lists.get(6).add(new Pair(6,2));
        lists.get(6).add(new Pair(6,3));
        lists.get(6).add(new Pair(6,4));

        board=new SudokuBoard(7,arr,lists);
        boards.add(board);
    }
    public static void main(String [] args)
    {
        addSudokus();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        final SudokuCanvas sudokuCanvas=new SudokuCanvas();
        sudokuCanvas.setSudokuBoard(boards.get(0));
        final MouseListener mouseListener1=new CanvasMouse(boards.get(0));
        final MouseListener mouseListener2=new CanvasMouse(boards.get(1));
        final MouseListener mouseListener3=new CanvasMouse(boards.get(2));
        sudokuCanvas.addMouseListener(mouseListener1);
        boards.get(0).addCanvas(sudokuCanvas);
        JMenuBar jMenuBar=new JMenuBar();
        JMenu jMenu=new JMenu("Level");
        JMenuItem jMenuItem1=new JMenuItem("Easy");
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuCanvas.setSudokuBoard(boards.get(0));
                sudokuCanvas.removeMouseListener(mouseListener2);
                sudokuCanvas.removeMouseListener(mouseListener3);
                sudokuCanvas.addMouseListener(mouseListener1);
                boards.get(0).addCanvas(sudokuCanvas);
                sudokuCanvas.repaint();
            }
        });
        jMenu.add(jMenuItem1);

        JMenuItem jMenuItem2=new JMenuItem("Medium");
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuCanvas.setSudokuBoard(boards.get(1));
                sudokuCanvas.removeMouseListener(mouseListener1);
                sudokuCanvas.removeMouseListener(mouseListener3);
                sudokuCanvas.addMouseListener(mouseListener2);
                boards.get(1).addCanvas(sudokuCanvas);
                sudokuCanvas.repaint();
            }
        });
        jMenu.add(jMenuItem2);

        JMenuItem jMenuItem3=new JMenuItem("Hard");
        jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudokuCanvas.setSudokuBoard(boards.get(2));
                sudokuCanvas.removeMouseListener(mouseListener2);
                sudokuCanvas.removeMouseListener(mouseListener1);
                sudokuCanvas.addMouseListener(mouseListener3);
                boards.get(2).addCanvas(sudokuCanvas);
                sudokuCanvas.repaint();
            }
        });
        jMenu.add(jMenuItem3);
        jMenuBar.add(jMenu);
        frame.setJMenuBar(jMenuBar);
        frame.add(sudokuCanvas);
        frame.setMinimumSize(new Dimension(300, 350));
        frame.setVisible(true);
    }
}
