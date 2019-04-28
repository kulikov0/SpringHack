package ru.rhdv.springhackapplication.ui.custom.bottomnavigation


import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.shape.EdgeTreatment
import android.support.design.shape.ShapePath
import android.view.View
import androidx.view.forEachIndexed

class CustomBottomNavigationViewTopEdgeTreatment(private val bottomNavigationMenuView: BottomNavigationMenuView,
                                                 var morphItemRadius: Float,
                                                 var morphVerticalOffset: Float,
                                                 var morphCornerRadius: Float) :
    EdgeTreatment() {

    lateinit var easyShapePath: CustomShapePath

    var lastSelectedItem: Int = 0
    var selectedItem: Int = 0

    override fun getEdgePath(length: Float, interpolation: Float, shapePath: ShapePath?) {
        easyShapePath = CustomShapePath.create(0f, morphVerticalOffset, length, morphVerticalOffset)

        bottomNavigationMenuView.forEachIndexed { i, view ->
            var morphHeightOffset = 0f

            if (view.visibility == View.VISIBLE && (i == selectedItem || i == lastSelectedItem)) {
                if (i == selectedItem) {
                    morphHeightOffset = interpolation * morphVerticalOffset
                } else if (i == lastSelectedItem) {
                    morphHeightOffset = (1 - interpolation) * morphVerticalOffset
                }

                val itemRect = view.globalVisibleRect

                val centerRadius = morphItemRadius
                val borderRadius = morphCornerRadius
                val centerX = itemRect.centerX().toFloat()
                val centerY = morphVerticalOffset + centerRadius - morphHeightOffset

                val centerCircle =
                    CustomShapePath.CircleShape(centerX, centerY, centerRadius, CustomShapePath.PathDirection.CLOCKWISE)

                val leftCircle = CustomShapePath.CircleShape(
                    centerX,
                    morphVerticalOffset - borderRadius,
                    borderRadius,
                    CustomShapePath.PathDirection.C_CLOCKWISE
                )
                centerCircle.shiftOutside(leftCircle, CustomShapePath.ShiftMode.LEFT)

                val rightCircle = CustomShapePath.CircleShape(
                    centerX,
                    morphVerticalOffset - borderRadius,
                    borderRadius,
                    CustomShapePath.PathDirection.C_CLOCKWISE
                )
                centerCircle.shiftOutside(rightCircle, CustomShapePath.ShiftMode.RIGHT)

                easyShapePath.addCircles(leftCircle, centerCircle, rightCircle)
            }
        }


        easyShapePath.applyOn(shapePath!!)
    }

    fun drawDebug(canvas: Canvas, paint: Paint) {
        easyShapePath.drawDebug(canvas, paint)
    }

    private inline val View.globalVisibleRect: Rect
        get() {
            val r = Rect()
            getGlobalVisibleRect(r)
            return r
        }

}