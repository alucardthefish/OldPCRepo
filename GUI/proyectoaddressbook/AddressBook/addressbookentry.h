#ifndef ADDRESSBOOKENTRY_H
#define ADDRESSBOOKENTRY_H

#include <QObject>
#include <QString>
#include <QDate>
#include <QStringList>

class AddressBookEntry : public QObject
{
    Q_OBJECT
public:
    explicit AddressBookEntry(QObject *parent = 0);
    ~AddressBookEntry();

    QString name() const;
    void setName(const QString &name);

    QString address() const;
    void setAddress(const QString &address);

    QDate birthday() const;
    void setBirthday(const QDate &birthday);

    QStringList phoneNumbers() const;
    void setPhoneNumbers(const QStringList &phoneNumbers);

signals:
    void nameChanged();
    void addressChanged();
    void birthdayChanged();
    void phoneNumbersChanged();

public slots:


private:
    QString m_name;
    QString m_address;
    QDate m_birthday;
    QStringList m_phoneNumbers;
};

#endif // ADDRESSBOOKENTRY_H
