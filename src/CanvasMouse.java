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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by vereena on 11/2/15.
 */
public class CanvasMouse implements MouseListener {
    SudokuBoard sudokuBoard;
    public CanvasMouse(SudokuBoard board)
    {
        sudokuBoard=board;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int n=sudokuBoard.getSize();
        int c=(290-10)/n;
        int x=e.getX();
        int y=e.getY();
        int x1=0,y1=0;
        for(int i=0;i<n;i++)
        {
            if(x<10+c*(i+1)) {
                x1 = i;
                break;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(y<10+c*(i+1)) {
                y1 = i;
                break;
            }
        }
        if(!sudokuBoard.isHardcoded(y1,x1)) {
            TextFieldFrame textFieldFrame = new TextFieldFrame(sudokuBoard, y1, x1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
