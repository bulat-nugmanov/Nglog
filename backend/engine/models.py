from __future__ import unicode_literals
from django.db import models
from django.contrib.auth.models import User

ADDRESS_LEN = 100
NAME_LEN = 25
COMMENT_LEN = 200


class Site(models.Model):
    name = models.CharField(max_length=25, unique=True, blank=False)
    address = models.CharField(max_length=ADDRESS_LEN)

    def __str__(self):
        return str(self.name)


class Unit(models.Model):
    serial = models.CharField(max_length=10, unique=True, blank=False)
    name = models.CharField(max_length=NAME_LEN)
    site = models.ForeignKey(Site)

    def __str__(self):
        return str(self.serial)


class Log(models.Model):
    user = models.ForeignKey(User)
    unit = models.ForeignKey(Unit)
    checkin = models.DateTimeField(blank=False)
    checkout = models.DateTimeField(blank=False)  # TODO figure out timing

    def __str__(self):
        string = '%s: %s' % (str(self.user), str(self.checkout))
        return string


class Comment(models.Model):
    text = models.CharField(max_length=COMMENT_LEN)
    log = models.ForeignKey(Log, blank=False)
    user = models.ForeignKey(User, blank=False)

    def __str__(self):
        return str(self.text)[0:NAME_LEN]


class Contact(models.Model):
    name = models.CharField(max_length=NAME_LEN, blank=False)
    organization = models.CharField(max_length=NAME_LEN)
    address = models.CharField(max_length=ADDRESS_LEN)
    number = models.CharField(max_length=15, blank=False)
    email = models.EmailField()
    unit = models.ForeignKey(Unit)

    def __str__(self):
        return str(self.name)
