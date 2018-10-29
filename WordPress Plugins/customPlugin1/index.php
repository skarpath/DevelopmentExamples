<?php
/*
Plugin Name:  Custom plugin 1
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  example 7 Enqueuing CSS/JS example
Version:      0.0.1
Author:       Stephen K
Author URI:   stephenkarpath.com
License:      GPLV2 or Later
License URI:  https://www.gnu.org/licenses/gpl-2.0.html
Text Domain:  mycp1
Domain Path:  /languages
*/

if ( !defined ( 'WPINC')){
  die;
}

//Get Folder paths
define('WPPLUGIN_URL', plugin_dir_url(  __FILE__  ) );
define('WPPLUGIN_PATH', plugin_dir_path(  __FILE__  ) );

//Create admin menus
include ( WPPLUGIN_PATH .'admin/index.php');

//Load Scripts for Admin and front end
include ( WPPLUGIN_PATH .'includes/scripts.php');
