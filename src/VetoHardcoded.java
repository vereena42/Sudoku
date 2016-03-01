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
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.List;

public class VetoHardcoded implements VetoableChangeListener{
    private SudokuBoard sudokuBoard;
    public VetoHardcoded(SudokuBoard sudokuBoard){
        this.sudokuBoard=sudokuBoard;
    }
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        int x,y;
        x=((FieldBean)evt.getSource()).getX();
        y=((FieldBean)evt.getSource()).getY();
        int value=((FieldBean)evt.getSource()).getValue();
        int area=((FieldBean)evt.getSource()).getArea();
        if(sudokuBoard.isHardcoded(x,y))
            throw new PropertyVetoException("Field is hardcoded",evt);
        int n=sudokuBoard.getSize();
        for(int i=0;i<n;i++)
        {
            if(sudokuBoard.getValue(x,i)==(Integer)evt.getNewValue() && sudokuBoard.isHardcoded(x,i))
                throw new PropertyVetoException("Conflict with hardcoded field",evt);
            if(sudokuBoard.getValue(i,y)==(Integer)evt.getNewValue() && sudokuBoard.isHardcoded(i,y))
                throw new PropertyVetoException("Conflict with hardcoded field",evt);
        }
        if(area!=0)
        {
            int x1,y1;
            List<Pair> list=sudokuBoard.getArea(area);
            for(Pair pair:list)
            {
                x1=pair.getX();
                y1=pair.getY();
                if(x1!=x || y!=y1)
                {
                    if(sudokuBoard.getValue(x1,y1)==(Integer)evt.getNewValue() && sudokuBoard.isHardcoded(x1,y1))
                        throw new PropertyVetoException("Conflict with hardcoded field",evt);
                }
            }
        }
    }
}
