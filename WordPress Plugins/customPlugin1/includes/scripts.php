<?php
  function mycp1_admin_scripts( $hook ){

    wp_register_script(
    'mycp1_admin',
    WPPLUGIN_URL . 'admin/scripts.js',
    ['jquery'],
    time()
    );

    wp_localize_script('mycp1_admin', 'mycp1',[
      'hook' => $hook
    ]);

    if('toplevel_page_mycp1' == $hook){
      wp_enqueue_script('mycp1_admin');
    }

  }

  add_action('admin_enqueue_scripts', 'mycp1_admin_scripts');




  function mycp1_frontend_scripts(){

    wp_register_script(
    'mycp1_frontend', //Title
    WPPLUGIN_URL . 'frontend/scripts.js', //PATH
    [], //Depencies
    time() //Version for cache
    );


    if(is_single()){
      wp_enqueue_script('mycp1_frontend');
    }

  }

  add_action('wp_enqueue_scripts', 'mycp1_frontend_scripts');
?>
