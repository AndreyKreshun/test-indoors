package com.example.testindoors

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class CustomExpandableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleTextView: TextView
    private val arrowImageView: ImageView
    private val expandableLayout: LinearLayout
    private var isExpanded = false

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.custom_expandable_item, this, true)

        titleTextView = findViewById(R.id.titleTextView)
        arrowImageView = findViewById(R.id.arrowImageView)
        expandableLayout = findViewById(R.id.expandableLayout)

        // Обработчик нажатия для заголовка
        findViewById<LinearLayout>(R.id.headerLayout).setOnClickListener {
            toggleExpandableLayout()
        }
    }

    private fun toggleExpandableLayout() {
        isExpanded = !isExpanded
        expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
        arrowImageView.setImageResource(
            if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
        )
    }

    fun setTitle(text: String) {
        titleTextView.text = text
    }

    fun setItems(items: List<String>) {
        expandableLayout.removeAllViews()
        for (item in items) {
            val textView = TextView(context).apply {
                text = item
                setPadding(8, 8, 8, 8)
            }
            expandableLayout.addView(textView)
        }
    }

}
