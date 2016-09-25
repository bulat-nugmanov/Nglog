import os
import secret

# TODO: reorganize settings
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SECRET_KEY = secret.SECRET_KEY
DB_NAME = secret.DB_NAME
DB_USER = secret.DB_USER
DB_PASS = secret.DB_PASS
DEBUG = False
ALLOWED_HOSTS = ['localhost', '127.0.0.1']

# base django apps
DJANGO_BASE_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
# add third party apps here
PREREQ_APPS = [
    'rest_framework',
    'rest_framework.authtoken',
    'djoser',
]
# add nglog backend apps here
PROJECT_APPS = [
    'engine',
]
INSTALLED_APPS = DJANGO_BASE_APPS + PREREQ_APPS + PROJECT_APPS

# TODO create new super user with token

REST_FRAMEWORK = {
    'DEFAULT_PERMISSION_CLASSES': (
        'rest_framework.permissions.IsAuthenticated',
    ),
    'DEFAULT_AUTHENTICATION_CLASSES': (
        'rest_framework.authentication.TokenAuthentication',
    ),
}

# add base middleware here
BASE_MIDDLEWARE = [
    # base
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
]
# add third party middleware here
PROJECT_MIDDLEWARE = [

]
MIDDLEWARE = BASE_MIDDLEWARE + PROJECT_MIDDLEWARE


ROOT_URLCONF = 'nglog_backend.urls'
TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]
WSGI_APPLICATION = 'nglog_backend.wsgi.application'


DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': DB_NAME,
        'USER': DB_USER,
        'PASSWORD': DB_PASS,
        'HOST': '',
        'PORT': '',
    },
}

# AUTHENTICATION_BACKENDS = ('mongoengine.django.auth.MongoEngineBackend',)
# https://docs.djangoproject.com/en/1.10/ref/settings/#auth-password-validators
AUTH_PASSWORD_VALIDATORS = [
    {
        'NAME': 'django.contrib.auth.password_validation.UserAttributeSimilarityValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.MinimumLengthValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.CommonPasswordValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.NumericPasswordValidator',
    },
]



# TODO: make dynamic
# https://docs.djangoproject.com/en/1.10/topics/i18n
TIME_ZONE = 'America/Vancouver'

LANGUAGE_CODE = 'en-us'

USE_I18N = True

USE_L10N = True

USE_TZ = True

# Static files (CSS, JavaScript, Images)
# https://docs.djangoproject.com/en/1.10/howto/static-files/

STATIC_URL = '/static/'
