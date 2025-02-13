package com.lapoushko.effectivetest.navigation.model

import  com.lapoushko.common.R
import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
@Serializable
sealed class ScreenBar(
    val route: String,
    val title: String,
    val setIcon: Int,
    val unsetIcon: Int? = null
) {
    @Serializable
    data object Main : ScreenBar(
        route = MAIN_ROUTE,
        title = MAIN_TITLE,
        setIcon = MAIN_SET_ICON
    )

    @Serializable
    data object Favourite : ScreenBar(
        route = FAVOURITE_ROUTE,
        title = FAVOURITE_TITLE,
        setIcon = FAVOURITE_SET_ICON,
        unsetIcon = FAVOURITE_UNSET_ICON
    )

    @Serializable
    data object Respond : ScreenBar(
        route = RESPOND_ROUTE,
        title = RESPOND_TITLE,
        setIcon = RESPOND_SET_ICON,
    )

    @Serializable
    data object Message : ScreenBar(
        route = MESSAGE_ROUTE,
        title = MESSAGE_TITLE,
        setIcon = MESSAGE_SET_ICON,
    )

    @Serializable
    data object Profile : ScreenBar(
        route = PROFILE_ROUTE,
        title = PROFILE_TITLE,
        setIcon = PROFILE_SET_ICON,
    )

    companion object {
        private const val MAIN_ROUTE = "main"
        private const val MAIN_TITLE = "Поиск"
        private val MAIN_SET_ICON = R.drawable.search_button

        private const val FAVOURITE_ROUTE = "favourite"
        private const val FAVOURITE_TITLE = "Избранное"
        private val FAVOURITE_SET_ICON = R.drawable.favourite_active
        private val FAVOURITE_UNSET_ICON = R.drawable.favourite_not_active

        private const val RESPOND_ROUTE = "respond"
        private const val RESPOND_TITLE = "Отклики"
        private val RESPOND_SET_ICON = R.drawable.respond

        private const val MESSAGE_ROUTE = "message"
        private const val MESSAGE_TITLE = "Сообщения"
        private val MESSAGE_SET_ICON = R.drawable.message

        private const val PROFILE_ROUTE = "profile"
        private const val PROFILE_TITLE = "Профиль"
        private val PROFILE_SET_ICON = R.drawable.profile
    }
}