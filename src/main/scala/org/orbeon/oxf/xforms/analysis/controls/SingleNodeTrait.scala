/**
 *  Copyright (C) 2012 Orbeon, Inc.
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.oxf.xforms.analysis.controls

import org.orbeon.saxon.om.Item
import org.orbeon.oxf.xforms.model.DataModel
import org.orbeon.oxf.xforms.analysis.ElementAnalysis

trait SingleNodeTrait extends ElementAnalysis {
  def isBindingOptional: Boolean
  // NOTE: Static controls do not by themselves support concrete bindings, but whether a control can bind to a certain
  // item or not is a property of the control type, not of a specific instance of concrete control. So we place this
  // here instead of in concrete controls. This also helps Form Builder, which sometimes needs to test whether
  // a binding is allowed without having access to a concrete control.
  def isAllowedBoundItem(item: Item): Boolean = DataModel.isAllowedBoundItem(item)
}

trait OptionalSingleNode extends SingleNodeTrait { def isBindingOptional = true }
trait RequiredSingleNode extends SingleNodeTrait { def isBindingOptional = false }