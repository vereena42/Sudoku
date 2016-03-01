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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame{
    private int x;
    private int y;
    private SudokuBoard sudokuBoard;
    JPanel jPanel=new JPanel();
    JTextField jTextField=new JTextField(30);
    JLabel message=new JLabel("To erase the value type 0");
    JLabel jLabel=new JLabel();
    TextFieldFrame(final SudokuBoard sudokuBoard,final int x,final int y)
    {
        this.x=x;
        this.y=y;
        this.sudokuBoard=sudokuBoard;
        setSize(400,200);
        setLocationRelativeTo(null);
        add(jPanel);
        jPanel.add(message);
        jPanel.add(jTextField);
        jPanel.add(jLabel);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = jTextField.getText();
                try {
                    int i = Integer.parseInt(input);
                    try {
                        sudokuBoard.setField(x, y, i);
                        setVisible(false);
                        dispose();
                    } catch (Exception a) {
                        jLabel.setText(a.getMessage());
                    }
                } catch (Exception ee) {
                    jLabel.setText("The value must be a number from 0 to n");
                }
            }
        });
        setVisible(true);
    }
}
