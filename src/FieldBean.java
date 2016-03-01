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

import java.beans.*;

public class FieldBean {
    private int x;
    private int y;
    private int value;
    private int area;
    private boolean hardcoded;
    private PropertyChangeSupport propertyChangeSupport=new PropertyChangeSupport(this);
    private VetoableChangeSupport vetoableChangeSupport=new VetoableChangeSupport(this);
    FieldBean(int x,int y,int value,int area){
        this.area=area;
        this.hardcoded=true;
        this.x=x;
        this.y=y;
        this.value=value;
    }
    FieldBean(int x,int y,int area){
        this.area=area;
        this.hardcoded=false;
        this.x=x;
        this.y=y;
        value=0;
    }
    public int getArea() {return area;}
    public boolean isHardcoded() {return hardcoded;}
    public int getValue(){
        return value;
    }
    public int getX() { return x;}
    public int getY() { return y;}
    public void setValue(int value) throws PropertyVetoException{
        int oldValue=this.value;
        vetoableChangeSupport.fireVetoableChange("value",oldValue,value);
        this.value=value;
        propertyChangeSupport.firePropertyChange("value",oldValue,value);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    public void addVetoableChangeListener(VetoableChangeListener listener){
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }
    public void removeVetoableChangeListener(VetoableChangeListener listener){
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }
}
