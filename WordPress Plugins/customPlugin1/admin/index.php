<?php

if ( ! defined('WPINC') ){
  return;
}

//Setup menus

function my_menu_pages(){
    add_menu_page(
      'mycp1', //Plugin Name
      'CUSTOM PLUGIN',    //Title
      'manage_options',  //Options
      'mycp1-home' //slug
     //Callback function
    );
    //Parent slug, Page title, Menu title, Manage options, Slug, Callback function
    add_submenu_page('mycp1-home', 'TITLE 1', 'MENU NAME 1','manage_options', 'mycp1-home' , 'cp_settings_sub_markup' );
    add_submenu_page('mycp1-home', 'TITLE 2', 'MENU NAME 2','manage_options', 'mycp1-page-2', 'cp_settings_sub_markup' );
}
add_action('admin_menu', 'my_menu_pages');



//Adds Setting markup page display
function cp_settings_markup(){
   //Double check user caplities
   if ( !current_user_can('manage_options' ) ) {
     return;
   }
   ?>
   <div class="wrap">
      <h1><?php esc_html_e( get_admin_page_title() ); ?></h1>
      <p><?php esc_html_e( 'Some content.'); ?></p>
   </div>
   <?php


}

function cp_settings_sub_markup(){
   //Double check user caplities
   if ( !current_user_can('manage_options' ) ) {
     return;
   }
   ?>
   <div class="wrap">
      <h1><?php esc_html_e( get_admin_page_title() ); ?></h1>
      <p><?php esc_html_e( 'Some content. Page 2'); ?></p>
   </div>
   <?php
}
