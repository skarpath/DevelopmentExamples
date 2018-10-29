<?php

//Create admin page
function wpplugin_settings_page()
{
   add_menu_page(
    __('Plugin name', 'wpplugin' ),
    __('Plugin Menu', 'wpplugin' ),
    'manage_options',
    'wpplugin',
    'wpplugin_settings_markup',
    'dashicons-wordpress-alt',
    100
  );




}

add_action( 'admin_menu' , 'wpplugin_settings_page' );

function wpplugin_settings_markup(){
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
