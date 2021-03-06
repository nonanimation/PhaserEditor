// The MIT License (MIT)
//
// Copyright (c) 2015, 2016 Arian Fornaris
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit
// persons to whom the Software is furnished to do so, subject to the
// following conditions: The above copyright notice and this permission
// notice shall be included in all copies or substantial portions of the
// Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
// NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
// USE OR OTHER DEALINGS IN THE SOFTWARE.
package phasereditor.canvas.ui.shapes;

import org.json.JSONObject;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import phasereditor.canvas.core.BaseObjectModel;
import phasereditor.canvas.core.MissingPrefabModel;

/**
 * @author arian
 *
 */
public class MissingPrefabNode extends Label implements IObjectNode {

	private MissingPrefabControl _control;

	public MissingPrefabNode(MissingPrefabControl control) {
		super();
		_control = control;

		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, new Insets(0))));
		setTextFill(Color.WHITE);

		MissingPrefabModel model = (MissingPrefabModel) getModel();
		JSONObject data = model.getSrcData();
		setText("Missing/corrupted prefab\n" + data.optString("prefabFile", "?"));

		setFont(Font.font(getFont().getFamily(), 20));
	}

	@Override
	public BaseObjectModel getModel() {
		return _control.getModel();
	}

	@Override
	public BaseObjectControl<?> getControl() {
		return _control;
	}

	@Override
	public Node getNode() {
		return this;
	}
}
