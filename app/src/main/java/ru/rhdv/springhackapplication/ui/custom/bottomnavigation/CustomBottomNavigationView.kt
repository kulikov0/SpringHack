package ru.rhdv.springhackapplication.ui.custom.bottomnavigation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Paint.Style.STROKE
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.shape.MaterialShapeDrawable
import android.support.design.shape.ShapePathModel
import android.support.design.widget.BottomNavigationView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.mail.mailhackathonapplication.R

class CustomBottomNavigationView : BottomNavigationView, BottomNavigationView.OnNavigationItemSelectedListener {

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.WHITE
        strokeWidth = 1.5f
        style = STROKE
        alpha = 50
    }
    private val height: Float

    private val topEdgeTreatment: CustomBottomNavigationViewTopEdgeTreatment
    private val materialShapeDrawable: MaterialShapeDrawable

    private var selectedItem = 0

    private var selectionAnimator: ValueAnimator? = null

    private var morphItemRadius: Float = 0f
        set(radius) {
            field = radius
            topEdgeTreatment.morphItemRadius = radius
            invalidate()
        }

    private var morphCornerRadius: Float = 0f
        set(radius) {
            field = radius
            topEdgeTreatment.morphCornerRadius = radius
            invalidate()
        }

    private var morphVerticalOffset: Float = 0f
        set(offset) {
            field = offset
            topEdgeTreatment.morphVerticalOffset = offset
            if (layoutParams != null) {
                layoutParams.height = (height + morphVerticalOffset).toInt()
            }

            invalidate()
        }

    private var drawDebug: Boolean = false
        set(enable) {
            field = enable
            invalidate()
        }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private var bottomNavigationMenuView: BottomNavigationMenuView

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
        defStyleAttr) {

        val a = resources.obtainAttributes(attrs, R.styleable.CustomBottomNavigationView)

        val typedValue = TypedValue()
        context.theme?.resolveAttribute(R.attr.colorPrimary, typedValue, true)
        //val backgroundTint = a.getColor(R.styleable.CustomBottomNavigationView_backgroundTint, typedValue.data)

        val morphItemRadius = a.getDimensionPixelSize(R.styleable.CustomBottomNavigationView_customCornerRadius, dpToPx(64f).toInt()).toFloat()
        val morphVerticalOffset = a.getDimensionPixelSize(R.styleable.CustomBottomNavigationView_customVerticalOffset, dpToPx(8f).toInt()).toFloat()
        val morphCornerRadius = a.getDimensionPixelSize(R.styleable.CustomBottomNavigationView_customCornerRadius, dpToPx(128f).toInt()).toFloat()
        a.recycle()

        height = dpToPx(56f)

        bottomNavigationMenuView = getChildAt(0) as BottomNavigationMenuView

        topEdgeTreatment = CustomBottomNavigationViewTopEdgeTreatment(
            bottomNavigationMenuView,
            morphItemRadius,
            morphVerticalOffset,
            morphCornerRadius)

        this.morphItemRadius = morphItemRadius
        this.morphVerticalOffset = morphVerticalOffset
        this.morphCornerRadius = morphCornerRadius

        val shapePathModel = ShapePathModel()
        shapePathModel.topEdge = topEdgeTreatment
        materialShapeDrawable = MaterialShapeDrawable(shapePathModel)
        materialShapeDrawable.isShadowEnabled = true
        materialShapeDrawable.paintStyle = Style.FILL
        materialShapeDrawable.setTint(resources.getColor(R.color.application_primary))

        background = materialShapeDrawable
        val menuParams = bottomNavigationMenuView.layoutParams as FrameLayout.LayoutParams
        menuParams.gravity = (Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL)

        setOnNavigationItemSelectedListener(this)

        setWillNotDraw(false)
    }
    override fun setOnNavigationItemSelectedListener(listener: OnNavigationItemSelectedListener?) {
        super.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
            if (listener !is CustomBottomNavigationView) {
                listener?.onNavigationItemSelected(it)
            }
            true
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val indexOfItemSelected = menu.indexOfItem(item)
        if (indexOfItemSelected != selectedItem) {
            topEdgeTreatment.lastSelectedItem = selectedItem
            topEdgeTreatment.selectedItem = indexOfItemSelected
            selectedItem = indexOfItemSelected

            selectionAnimator?.end()
            selectionAnimator?.cancel()

            selectionAnimator = ValueAnimator.ofFloat(0f, 1f)
            selectionAnimator?.addUpdateListener {
                materialShapeDrawable.interpolation = it.animatedValue as Float
            }

            selectionAnimator?.duration = 200
            selectionAnimator?.interpolator = DecelerateInterpolator()

            selectionAnimator?.start()

        }

        return true
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        layoutParams.height = (height + morphVerticalOffset).toInt()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (drawDebug) {
            topEdgeTreatment.drawDebug(canvas, paint)
        }
    }

    private fun dpToPx(dp: Float): Float {
        return resources.displayMetrics.density * dp
    }

    private fun Menu.indexOfItem(item: MenuItem): Int {
        for (i in 0 until this.size()) {
            val menuItem = menu.getItem(i)
            if (menuItem.itemId == item.itemId) {
                return i
            }
        }
        return -1
    }
}